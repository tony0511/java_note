package com.qf.act;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * Thanks for Everything.
 */
public class HelloPro {

	private ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();


	public void deploy(){
		RepositoryService repositoryService = processEngine.getRepositoryService();
		DeploymentBuilder deployment = repositoryService.createDeployment();
		deployment.addClasspathResource("lz.bpmn");
		deployment.name("学生请假");
		Deployment deploy = deployment.deploy();
		System.out.println("部署ID"+deploy.getId());
		System.out.println("部署名称"+deploy.getName());
	}

	public void deployZip(){
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("hello2.zip");
		ZipInputStream zipInputStream = new ZipInputStream(resourceAsStream);
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deploy = repositoryService.createDeployment()
				.name("部署2")
				.addZipInputStream(zipInputStream)
				.deploy();
		System.out.println(deploy.getId());

	}

	public void  start(){
		RuntimeService runtimeService = processEngine.getRuntimeService();
		Map<String, Object> variables = new HashMap<>();
		variables.put("uname","小张");
		ProcessInstance myProcess_1 = runtimeService.startProcessInstanceByKey("ttt",variables);
		System.out.println("流程实例"+myProcess_1.getId());
		System.out.println("流程定义id"+myProcess_1.getProcessDefinitionId());
	}



	public void findTask(){
		TaskService taskService = processEngine.getTaskService();
		List<Task> list = taskService.createTaskQuery()
				.taskAssignee("主管")
				.list();
		for (Task task : list) {
			System.out.println(task.getId()+"\t"+task.getName());
		}
	}//2504

	public void com(){
		TaskService taskService = processEngine.getTaskService();
		Map<String, Object> variables = new HashMap<>();
		variables.put("msg","4");

		taskService.complete("5002",variables);
	}

	public void find(){
		List<ProcessDefinition> list = processEngine.getRepositoryService()
				.createProcessDefinitionQuery()
				.processDefinitionKey("myProcess_1")
				.list();
		for (ProcessDefinition processDefinition : list) {
			System.out.println(processDefinition.getId()+"\t"+processDefinition.getName());
		}

	}

	public void find2(){
		ProcessDefinition processDefinition = processEngine.getRepositoryService()
				.createProcessDefinitionQuery()
				.processDefinitionId("myProcess_1:2:7504")
				.singleResult();
		System.out.println(processDefinition.getId()+"\t"+processDefinition.getVersion());


	}

	public void del(){
		processEngine.getRepositoryService()
				.deleteDeployment("1",true);

	}
	public void find3(){
		ProcessInstance processInstance = processEngine.getRuntimeService()
				.createProcessInstanceQuery()
				.processInstanceId("17501")
				.singleResult();
		if(processInstance!=null){
			System.out.println("执行"+processInstance.getId());
		}else{
			System.out.println("完");
		}
	}

	public void find4(){
		List<HistoricTaskInstance> list = processEngine.getHistoryService()
				.createHistoricTaskInstanceQuery()
				.taskAssignee("主管")
				.unfinished()
				.list();
		for (HistoricTaskInstance historicTaskInstance : list) {
			System.out.println("任务ID"+historicTaskInstance.getId());
			System.out.println("实例id"+historicTaskInstance.getProcessInstanceId());
			System.out.println(historicTaskInstance.getAssignee());
			System.out.println(historicTaskInstance.getCreateTime());
			System.out.println("结束时间"+historicTaskInstance.getEndTime());
		}
	}

//	public void setVar(){
//		TaskService taskService = processEngine.getTaskService();
//		String tid = "25004";
//		taskService.setVariable(tid,"reson","感冒");
//		taskService.setVariableLocal(tid,"days",2);
//
//	}

	private void com1(){
		Map<String, Object> variables = new HashMap<>();
		variables.put("days",2);
		variables.put("reson","感冒");
		processEngine.getTaskService()
				.complete("40004",variables);

	}

	public void getVar(){
		TaskService taskService = processEngine.getTaskService();
		String tid = "27504";
		Object days = taskService.getVariable(tid, "days");
		System.out.println("请假天数"+days);
		String reson = (String)taskService.getVariable(tid, "reson");
		System.out.println("原因"+reson);
	}

	public void com2(){
		TaskService taskService = processEngine.getTaskService();
		String tid = "42504";
		Object days = taskService.getVariable(tid, "days");
		System.out.println("请假天数"+days);
		String reson = (String)taskService.getVariable(tid, "reson");
		System.out.println("原因"+reson);

		taskService.complete("42504");
	}



	public static void main(String[] args) {
		HelloPro helloPro = new HelloPro();
//		helloPro.deploy();
//		helloPro.deployZip();
		helloPro.start();
//		helloPro.findTask();
//		helloPro.com();

//		helloPro.find();
//		helloPro.find2();
//		helloPro.del();

//		helloPro.find3();
//		helloPro.find4();

//		helloPro.setVar();
//		helloPro.com1();
//		helloPro.getVar();
//		helloPro.com2();
	}
}
