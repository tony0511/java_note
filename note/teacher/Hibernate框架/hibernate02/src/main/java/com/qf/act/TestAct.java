package com.qf.act;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * Thanks for Everything.
 */
public class TestAct {

	public void  testCreat(){
//		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
//		configuration.setJdbcDriver("com.mysql.jdbc.Driver");
//		configuration.setJdbcUrl("jdbc:mysql://localhost:3306/db_activiti?characterEncoding=utf-8");
//		configuration.setJdbcUsername("root");
//		configuration.setJdbcPassword("");
//		configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		ProcessEngine processEngine = configuration.buildProcessEngine();
	}

	public static void main(String[] args) {
		TestAct testAct = new TestAct();
		testAct.testCreat();
	}

}
