package stateMachine;
import java.io.File;
import java.util.HashMap;

import jeff.ini.Ini;

public class ConfigLoader {
	private Ini _ini;
	private HashMap<String, Space>  _spaces  = new HashMap<String, Space>();
	private HashMap<String, Portal> _portals = new HashMap<String, Portal>();
	private HashMap<String, Agent>  _agents  = new HashMap<String, Agent>();
	
	public ConfigLoader(File iniFile) {
		_ini = new Ini(iniFile);
	}
	
	public Agent buildAll() {
		_buildSpaces();
		_buildPortals();
		_buildExits();
		_buildDestinations();
		_buildAgents();
		return _selectStartAgent();
	}
	
	private void _buildSpaces() {
		for(String spaceName : _ini.keys("spaces")) {
			String description  = _ini.get("spaces", spaceName);
			String image = _ini.get("images", spaceName);
			
			Space spaceInstance = new Space(spaceName, description, null, image);
			
			_spaces.put(spaceName, spaceInstance);		
		}
	}
	
	private void _buildPortals() {
		for(String portalName : _ini.keys("portals")) {
			String description = _ini.get("portals", portalName);
			
			Portal portalInstance = new Portal(portalName, description, null);
			
			_portals.put(portalName, portalInstance);
		}
	}
	
	private void _buildExits() {
		for(String spaceName : _ini.keys("exits")) {
			String portalName = _ini.get("exits", spaceName);
			
			Space spaceInstance = _spaces.get(spaceName);
			Portal portalInstance = _portals.get(portalName);
			
			if(portalInstance == null) {
				System.out.println("Error: The portal specified does not exist");
				
				System.exit(1);
			}
			
			spaceInstance.setPortal(portalInstance);
		}
	}
	
	private void _buildDestinations() {
		for(String portalName : _ini.keys("destinations")) {
			String spaceName = _ini.get("destinations", portalName);
			
			Space spaceInstance = _spaces.get(spaceName);
			Portal portalInstance = _portals.get(portalName);
			
			if(spaceInstance == null) {
				System.out.println("Error: The space specified does not exist");
				
				System.exit(1);
			}
			
			portalInstance.setDestination(spaceInstance);
		}
	}
	
	private void _buildAgents() {
		for(String agentName : _ini.keys("agents")) {
			String spaceName = _ini.get("agents", agentName);
			
			Space spaceInstance = _spaces.get(spaceName);
			
			Agent agentInstance = new Agent(agentName, spaceInstance);
			
			_agents.put(agentName, agentInstance);
		}
	}
	
	private Agent _selectStartAgent() {
		String agentName = _ini.get("start", "agent");
		
		Agent startAgent = _agents.get(agentName);
		
		if(startAgent == null) {
			System.out.println("Error: No start agent declared");
			
			System.exit(1);
		}
		
		return startAgent;
	}
}
