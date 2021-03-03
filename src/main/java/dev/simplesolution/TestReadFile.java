package dev.simplesolution;

import java.io.File;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class TestReadFile implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(TestReadFile.class);

	@Override
	public void run(String... args) throws Exception {
		File file = ResourceUtils.getFile("classpath:data.txt");
		if(file.exists()) {
			byte[] fileData = Files.readAllBytes(file.toPath());
			String fileContent = new String(fileData);
			
			logger.info("data.txt file content:");
			logger.info(fileContent);
		}
	}
}