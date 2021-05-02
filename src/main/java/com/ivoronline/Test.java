package com.ivoronline;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Test {

  public static void main(String[] args) throws JAXBException {
    marshalBook();
    marshalPerson();
  }

  private static void marshalPerson() throws JAXBException {

    //CREATE PERSON
    Person  person = new Person();
            person.setId  (1);
            person.setName("John");
            person.setAge (20);

    //MARSHAL PERSON
    JAXBContext context    = JAXBContext.newInstance(Person.class);
    Marshaller  marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(person, new File("./person.xml"));
  }


  private static void marshalBook() throws JAXBException {
    Book book = new Book();
    book.setId(1L);
    book.setName("Book1");
    book.setAuthor("Author1");

    JAXBContext context = JAXBContext.newInstance(Book.class);
    Marshaller mar= context.createMarshaller();
    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    mar.marshal(book, new File("./book.xml"));
  }

}
