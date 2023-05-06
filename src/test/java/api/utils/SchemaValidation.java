package api.utils;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;


public class SchemaValidation {
	
	
	static JsonNode schemaNode, dataNode;
	static JsonSchemaFactory schemaFactory;
	static JsonSchema schema;
	static File file;
	static ProcessingReport report;

	
	public static void validateJSONSchema(String schemaFileProperty, String responseJson) throws IOException, ProcessingException{
		
		String schemaFileName= PropUtil.readProperty(schemaFileProperty);
		
		//Load and Compile the JSON Schema File
		file=new File(System.getProperty("user.dir"+"src/test/java/api/schemas/"+schemaFileName));
		schemaNode=JsonLoader.fromFile(file);
		schemaFactory=JsonSchemaFactory.byDefault();
		schema=schemaFactory.getJsonSchema(schemaNode);
		
		//Load and validate the JSON data
		dataNode=JsonLoader.fromString(responseJson);
		report = schema.validate(dataNode);
		
		//Check Validation Result
		if(report.isSuccess())
			System.out.println("Validation Successful");
		else{
			System.out.println("Validation Failed");
			
			for(ProcessingMessage message: report){
				System.out.println(message.getMessage());
			}
		}
		
		
		
	}
	
	
	

}
