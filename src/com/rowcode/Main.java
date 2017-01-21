/*
 * Main.java
 *
 * Copyright 2017 Rodrigo Vieira <rodvieirasilva@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */


package com.rowcode;


import javax.naming.SizeLimitExceededException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Main Class
 */
public class Main {

    /**
     * main method
     *
     * @param args Arguments, input and output files
     *             0 -> inputFileName default 'entrada.txt'
     *             1 -> outputFileName default 'saida.txt'
     *             2 -> useJava8ForEachs default 'false'
     */
    public static void main(String[] args) {

        System.out.println("Started!");
        //default values
        String inputFileName = "entrada.txt";
        String outputFileName = "saida.txt";
        boolean useJava8ForEachs = true;

        try {
            if (args != null && args.length > 0) {
                inputFileName = args[0];
                if (args.length > 1) {
                    outputFileName = args[1];
                    if (args.length > 2) {
                        useJava8ForEachs = Boolean.parseBoolean(args[3]);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.printf("Params error: %s; \n run with defaults: \n" +
                    "             0 -> inputFileName default 'entrada.txt'  \n" +
                    "             1 -> outputFileName default 'saida.txt'  \n" +
                    "             2 -> useJava8ForEachs default 'false' \n", ex.getMessage());
        }

        if (useJava8ForEachs) {
            //Second Test with foreach java8
            reverseFileLinkedListJava8(inputFileName, outputFileName);
        } else {
            //First Test with try java 7
            reverseFileLinkedListJava7(inputFileName, outputFileName);
        }

        System.out.println("Finished!");
    }

    /**
     * Reverse a file and save in another file, simple test try-with-resources
     *
     * @param inputFileName  Input File for the Copy
     * @param outputFileName Destination File
     */
    public static void reverseFileLinkedListJava7(String inputFileName, String outputFileName) {
        try {
            //list1
            LinkedList<String> list1 = new LinkedList<String>();

            //try-with-resources, java7
            try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
                //read and add lines
                String line = br.readLine();
                while (line != null) {
                    list1.add(line);
                    line = br.readLine();
                }
            }
            //reverse to other list
            LinkedList<String> list2 = new LinkedList<String>();
            list1.reverseToList(list2);

            //try-with-resources, java7, writer
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                //control first time
                boolean first = true;
                for (Node<String> node : list2) {
                    //New line after first item
                    if (first) {
                        first = false;
                    } else {
                        writer.newLine();
                    }
                    writer.write(node.getValue());
                }
            }

        } catch (SizeLimitExceededException ex) {
            System.out.println("Error in insert in a list1: " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("File not found, verify file: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error I/O: " + ex.getMessage());
        }
    }

    /**
     * Reverse a file and save in another file, simple test forEach
     * @param inputFileName
     * @param outputFileName
     */
    public static void reverseFileLinkedListJava8(String inputFileName, String outputFileName) {
        try {
            //list1
            LinkedList<String> list1 = new LinkedList<String>();
            //First foreach in lines
            try (Stream<String> stream = Files.lines(Paths.get(inputFileName))) {
                stream.forEach(line -> {
                    try {
                        list1.add(line);
                    } catch (SizeLimitExceededException ex) {
                        System.out.println("Error in insert in a list1: " + ex.getMessage());
                    }
                });
            }
            //Reverse
            final LinkedList<String> list2 = new LinkedList<String>();
            list1.reverseToList(list2);

            //Final foreach to writer
            final Path path = Paths.get(outputFileName);
            try (final BufferedWriter writer = Files.newBufferedWriter(path)) {
                list2.forEach(node -> {
                    try {
                        //new line after first element
                        if (list2.getFirst() != node) {
                            writer.newLine();
                        }
                        writer.write(node.getValue());
                    } catch (IOException ex) {
                        System.out.println("Error write file: " + ex.getMessage());
                    }
                });
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found, verify file: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error I/O: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Fatal error: " + ex.getMessage());
        }
    }
}

