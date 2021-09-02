package com.hangarww.vaccination;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hangarww.vaccination.model.AadharCard;
import com.hangarww.vaccination.model.VaccinatedPerson;

import com.hangarww.vaccination.model.VaccinationCentre;
import com.hangarww.vaccination.model.Vaccine;
import com.hangarww.vaccination.model.VaccineAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static com.hangarww.vaccination.utility.MongoUtils.loadResource;

@SpringBootApplication
public class VaccinationApplication implements CommandLineRunner {

	@Autowired
	private MongoTemplate mongoTemplate;

	private static final String AADHAR_CARDS = "AadharCards";
	private static final String VACCCINATED_PEOPLE = "VaccinatedPeople";
	private static final String VACCINATION_CENTRES = "VaccinationCentres";
	private static final String VACCINES = "Vaccines";
	private static final String VACCINE_AVAILABILITIES = "VaccineAvailabilities";



	public static void main(String[] args) {
		SpringApplication.run(VaccinationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		InputStream in = getClass().getClassLoader().getResourceAsStream("imports"
				+ "/aadhar_card.json");
		List<AadharCard> aadharCardList = Arrays.asList(mapper.readValue(in,
				AadharCard[].class));

		mongoTemplate.dropCollection(AADHAR_CARDS);
		mongoTemplate.createCollection(AADHAR_CARDS);
		mongoTemplate.insertAll(aadharCardList);

		in = getClass().getClassLoader().getResourceAsStream("imports"
				+ "/vaccinated_person.json");

		List<VaccinatedPerson> vaccinatedPersonList = Arrays.asList(mapper.readValue(in,
				VaccinatedPerson[].class));

		mongoTemplate.dropCollection(VACCCINATED_PEOPLE);
		mongoTemplate.createCollection(VACCCINATED_PEOPLE);
		mongoTemplate.insertAll(vaccinatedPersonList);

		in = getClass().getClassLoader().getResourceAsStream("imports"
				+ "/vaccination_centre.json");

		List<VaccinationCentre> vaccinationCentreList = Arrays.asList(mapper.readValue(in,
				VaccinationCentre[].class));
		mongoTemplate.dropCollection(VACCINATION_CENTRES);
		mongoTemplate.createCollection(VACCINATION_CENTRES);
		mongoTemplate.insertAll(vaccinationCentreList);

		in = getClass().getClassLoader().getResourceAsStream("imports"
				+ "/vaccine.json");

		List<Vaccine> vaccineList = Arrays.asList(mapper.readValue(in,
				Vaccine[].class));
		mongoTemplate.dropCollection(VACCINES);
		mongoTemplate.createCollection(VACCINES);
		mongoTemplate.insertAll(vaccineList);

		in = getClass().getClassLoader().getResourceAsStream("imports"
				+ "/vaccine_availability.json");

		List<VaccineAvailability> vaccineAvailabilityList = Arrays.asList(mapper.readValue(in,
				VaccineAvailability[].class));
		mongoTemplate.dropCollection(VACCINE_AVAILABILITIES);
		mongoTemplate.createCollection(VACCINE_AVAILABILITIES);
		mongoTemplate.insertAll(vaccineAvailabilityList);
	}
}
