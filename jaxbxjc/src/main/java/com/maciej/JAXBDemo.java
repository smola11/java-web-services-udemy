package com.maciej;

import com.bharatthippireddy.patient.Patient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

// This JAXB Runtime API is used by web service engines like Apache CXF and is generally rarely used directly.

public class JAXBDemo {

    public static void main(String[] args) {
        try {
            // Initial entry point if we want to marshall/unmarshall
            JAXBContext context = JAXBContext.newInstance(Patient.class); // class that we want to serialize/deserialize
            Marshaller marshaller = context.createMarshaller();

            Patient patient = new Patient();
            patient.setId(123);
            patient.setName("Patient name");

            StringWriter writer = new StringWriter();
            marshaller.marshal(patient, writer);

            System.out.println(writer.toString());

            Unmarshaller unmarshaller = context.createUnmarshaller();
            Patient deserializedPatient = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
            System.out.println(deserializedPatient.getName());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
