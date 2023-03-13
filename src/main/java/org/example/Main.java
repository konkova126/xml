package org.example

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("books.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // где будем парсить элемент
        Document document = builder.parse(file);

        Element booksElement = (Element) document.getElementsByTagName("книги").item(0);
        // достать из значения атрибута
        String shop = booksElement.getAttribute("Книги");
        // получаем все книги
        NodeList bookNodeList = document.getElementsByTagName("книга");

        List<Book> bookList = new ArrayList<>();
        for (int i=0; i < bookNodeList.getLength(); i++) {
            if (bookNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element bookElement = (Element) bookNodeList.item(i);
                // создаем объект
                Book book = new Book();
                book.setShop(shop);
                book.setNumber(Integer.valueOf(bookElement.getAttribute("номер")));

                // пробегаемся по внутренним элементам
                NodeList childNodes = bookElement.getChildNodes();
                for (int j =0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                       Element childElement = (Element) childNodes.item(j);

                       switch(childElement.getNodeName()) {
                           case "название": {
                               book.setName(childElement.getTextContent());
                           } break;
                           case "автор": {
                               book.setAuthor(childElement.getTextContent());
                           } break;
                           case "страниц": {
                               book.setPage(Integer.valueOf(childElement.getTextContent()));
                           } break;
                           case "цена": {
                               book.getPrice().setValue(Double.valueOf(childElement.getTextContent()));
                               book.getPrice().setCurrency(childElement.getAttribute("валюта"));
                           } break;
                           case "жанр": {
                               book.setGenre(childElement.getTextContent());
                           } break;
                           case "количество": {
                               book.setAmount(Integer.valueOf(childElement.getTextContent()));
                           } break;
                           case "издательство": {
                               book.setHouse(childElement.getTextContent());
                           } break;
                           case "вес": {
                               book.setWeight(Integer.valueOf(childElement.getTextContent()));
                           } break;
                           case "тираж": {
                               book.setCurculation(Integer.valueOf(childElement.getTextContent()));
                           } break;
                           case "публикация": {
                               book.setYear(Integer.valueOf(childElement.getTextContent()));
                           }

                       }
                    }
                }

                bookList.add(book);

            }
        }

        bookList.forEach(System.out::println);



    }

}
