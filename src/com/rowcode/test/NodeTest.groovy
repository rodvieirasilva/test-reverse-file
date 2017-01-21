/*
 * NodeTest.java
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

import com.rowcode.Node

class NodeTest extends groovy.util.GroovyTestCase {

    private Node<String> secondNodeForTest;
    private Node<String> firstNodeForTest;

    @Override
    protected void setUp() throws Exception {
        super.setUp()

        secondNodeForTest = new Node<String>("30", null);
        firstNodeForTest = new Node<>("35", secondNodeForTest);
    }

    void testGetNextNull() {
        assertNull(secondNodeForTest.getNext());
    }

    void testGetNext() {
        assertEquals(secondNodeForTest, firstNodeForTest.getNext());
    }

    void testSetNext() {
        secondNodeForTest.setNext(new Node<String>("23", null));
    }


    void testGetValue() {
        assertEquals("35", firstNodeForTest.getValue());
    }

    void testSetValue() {
        secondNodeForTest.setValue("45");
        assertEquals("45", secondNodeForTest.getValue());
    }
}
