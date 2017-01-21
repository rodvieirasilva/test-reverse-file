/*
 * LinkedListTest.java
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

package com.rowcode.test

import com.rowcode.LinkedList
import com.rowcode.Node


class LinkedListTest extends GroovyTestCase {
    LinkedList<String> linkedTest;
    private int capacity;
    private int count;

    void setUp() {
        super.setUp();
        capacity = 100;
        count = 97;

        linkedTest = new LinkedList<>(capacity);

        for (int i = 0; i < count; i++) {
            linkedTest.add("Test" + i);
        }
    }

    void testGetCount() {
        assertEquals(count, linkedTest.getCount());
    }

    void testGetCapacity() {
        assertEquals(capacity, linkedTest.getCapacity());
    }

    void testInsertFirst() {
        Node<String> node = linkedTest.insertFirst("New Test");
        assertNotNull(node);
        assertEquals(node, linkedTest.getFirst());
    }

    void testAdd() {
        Node<String> node = linkedTest.add("New Test 2");
        assertNotNull(node);
    }

    void testReverseToList() {
        LinkedList<String> linkedTest2 = new LinkedList<>(capacity);
        linkedTest.reverseToList(linkedTest2);

        LinkedList<String> linkedTest3 = new LinkedList<>(capacity);
        linkedTest2.reverseToList(linkedTest3);

        Node<String> node1 = linkedTest.getFirst();
        Node<String> node2 = linkedTest3.getFirst();

        while (node1 != null) {
            assertEquals(node1.getValue(), node2.getValue());
            node1 = node1.getNext();
            node2 = node2.getNext();
        }
    }

    void testIterator() {
        LinkedList<String> linkedTest3 = new LinkedList<>(capacity);
        for(Node<String> node : linkedTest)
        {
            linkedTest3.add(node.getValue())
        }
        Node<String> node2 = linkedTest3.getFirst();

        for(Node<String> node : linkedTest)
        {
            assertEquals(node.getValue(), node2.getValue());
            node2 = node2.getNext();
        }
    }

    void testGetFirst() {
        Node<String> node = linkedTest.insertFirst("New Test First");
        assertEquals(node, linkedTest.getFirst());
    }
}
