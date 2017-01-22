/*
 * LinkedList.java
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
import java.util.Iterator;

/**
 * A simple linked list, implements Iterator and Iterable to facilitate
 *
 * @param <T> Type of values in the Node
 */
public class LinkedList<T> implements Iterator<Node<T>>, Iterable<Node<T>> {

    /**
     * Current Node to Iterator
     */
    private Node<T> current;

    /**
     * First Node of the list
     */
    private Node<T> first;

    /**
     * Count of the elements
     */
    private int count;

    /**
     * Capacity of the List
     */
    private int capacity;


    /**
     * Constructor with default parameters:
     * capacity = Integer.MAX_VALUE
     * count = 0
     * first = null
     */
    public LinkedList() {
        this.capacity = Integer.MAX_VALUE;
        //Code is not necessary, but it facilitates the
        this.count = 0;
        this.first = null;
    }

    public LinkedList(int capacity) {
        //Call default constructor
        this();
        //Capacity
        this.capacity = capacity;
    }

    /**
     * Count of elements
     *
     * @return Returns count of the elements
     */
    public int getCount() {
        return count;
    }

    /**
     * Capacity of List
     *
     * @return Returns capacity of list
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Inserts an element at the top of the list
     *
     * @param value Value of the Node
     * @return Returns the node
     */
    public Node<T> insertFirst(T value) throws SizeLimitExceededException {

        verifyLimit();

        //Create the new Node and set the point
        first = new Node(value, first);

      /*Other form
        Node<T> temp = first;
        first = new Node(value, temp);*/

        //New element added
        count++;

        return first;
    }

    /**
     * Add a Node in final
     *
     * @param value value of the node
     * @return Returns the node
     * @throws SizeLimitExceededException
     */
    public Node<T> add(T value) throws SizeLimitExceededException {

        verifyLimit();

        //Create new Node, the next
        Node<T> node = new Node<T>(value, null);

        //First element
        if (first == null) {
            first = node;
        } else {
            //Move to last
            Node<T> parent = first;
            while (parent.getNext() != null) {
                parent = parent.getNext();
            }
            //Update the Next
            parent.setNext(node);
        }
        //New element added
        count++;
        return node;
    }

    /**
     * Reverse list to another list, Does not clean the newlist
     *
     * @param newList to save reverse, Does not clean the newlist
     * @return Returns newList
     * @throws SizeLimitExceededException
     */
    public LinkedList<T> reverseToList(LinkedList<T> newList) throws SizeLimitExceededException {
        Node<T> node = first;
        while (node != null) {
            //Insert in first
            newList.insertFirst(node.getValue());
            node = node.getNext();
        }
        return newList;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {

        if (current == null) {
            return first != null;
        }

        boolean _hasNext = current.getNext() != null;

        //Move to the beginners
        if (!_hasNext) {
            current = null;
        }
        return _hasNext;
        //}
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override
    public Node<T> next() {

        //first time
        if (current == null) {
            current = first;
        } else {
            current = current.getNext();
        }
        return current;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Node<T>> iterator() {
        return this;
    }

    /**
     * Get first element
     *
     * @return Returns the first element
     */
    public Node<T> getFirst() {
        return first;
    }


    /**
     * Verify Limits to throw exception
     *
     * @throws SizeLimitExceededException
     */
    private void verifyLimit() throws SizeLimitExceededException {
        if (count == capacity) {
            throw new SizeLimitExceededException("Size Limit Exceeded, capacity: " + capacity);
        }
    }
}
