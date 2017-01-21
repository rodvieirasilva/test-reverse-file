/*
 * MainTest.java
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

import com.rowcode.Main

class MainTest extends GroovyTestCase {

    void testMain() {
        String[] params = new String[3];
        Main.main(["entrada.txt", "saida.txt", "true"].toArray(params));
        Main.main(["entrada.txt", "saida.txt", "false"].toArray(params));
    }

    void testReverseFileLinkedListJava7() {
        Main.reverseFileLinkedListJava7("entradaNumeros.txt", "saidaNumeros.txt");
    }

    void testReverseFileLinkedListJava8() {
        Main.reverseFileLinkedListJava7("entradaNumeros.txt", "saidaNumeros.txt");
    }
}
