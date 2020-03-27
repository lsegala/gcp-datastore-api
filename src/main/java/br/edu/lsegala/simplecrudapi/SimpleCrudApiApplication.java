package br.edu.lsegala.simplecrudapi;

import br.edu.lsegala.simplecrudapi.model.AccessEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.datastore.core.convert.DatastoreCustomConversions;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import static java.util.Arrays.asList;

@SpringBootApplication
public class SimpleCrudApiApplication {
	//Converter to write custom Album type
	static final Converter<AccessEnum, String> ACCESS_STRING_CONVERTER =
			new Converter<AccessEnum, String>() {
				@Override
				public String convert(AccessEnum access) {
					return access.toString();
				}
			};

	static final Converter<String, AccessEnum> STRING_ACCESS_CONVERTER =
			new Converter<String, AccessEnum>() {
				@Override
				public AccessEnum convert(String access) {
					return AccessEnum.findByName(access);
				}
			};

	public static void main(String[] args) {
		SpringApplication.run(SimpleCrudApiApplication.class, args);
	}

	@Bean
	public DatastoreCustomConversions datastoreCustomConversions() {
		return new DatastoreCustomConversions(asList(
				ACCESS_STRING_CONVERTER,
				STRING_ACCESS_CONVERTER));
	}
}
