package mwo.addressbook.ui;

import java.io.File;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Please provide exactly one input parameter which is a file of addresses");
			System.exit(0);
		}
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-configuration.xml");
		TaskImport taskImport = (TaskImport) ctx.getBean(TaskImport.class);
		taskImport.importAddresses(new File(args[0]));
		TaskOutput taskOutput = (TaskOutput) ctx.getBean(TaskOutput.class);
		taskOutput.performOutputs();
		ctx.close();
		
	}
}
