/*
 * Node.java
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

/**
 * Simple Node class to use in data structures
 *
 * @param <T> Type of the value
 */
public class Node<T> {
    /**
     * Value of the node
     */
    private T value;

    /**
     * Pointer to next Node
     */
    private Node<T> nextNode;


    /**
     * Constructor default
     *
     * @param value    Value of the Node
     * @param nextNode Pointer to next Node
     */
    public Node(T value, Node<T> nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    /**
     * Get the next Node
     *
     * @return the next Node or null
     */
    public Node<T> getNext() {
        return this.nextNode;
    }

    /**
     * Set the next Node
     *
     * @param next Next Node
     */
    public void setNext(Node<T> next) {
        this.nextNode = next;
    }

    /**
     * Get the value of the Node
     * @return the Value
     */
    public T getValue() {
        return value;
    }

    /**
     * Set the value of the node
     * @param val Value of the node
     */
    public void setValue(T val) {
        this.value = val;
    }


}
