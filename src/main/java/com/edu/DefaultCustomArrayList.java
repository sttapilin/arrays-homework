package com.edu;

import java.util.Arrays;
import java.util.Iterator;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {
    int size = 0;
    E[] array;

    public DefaultCustomArrayList() {
        array = (E[]) new Object[size];
    }

    @Override
    public boolean add(E element) {
        size++;
        if (size > array.length) {
            array = Arrays.copyOf(array, size);
        }
        array[size - 1] = element;
        return true;
    }

    @Override
    public boolean remove(E element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                for (int j = i + 1; j < array.length; j++) {
                    array[i] = array[j];
                }
                array = Arrays.copyOf(array, array.length - 1);
                return true;
            }
        }
        return false;
    }

    private void remove(int index) {
        if (index > 0 || index < array.length) {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
                System.out.println(array[i]);
            }
        }
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public void clear() {
        array = (E[]) new Object[0];
    }

    @Override
    public boolean contains(E element) {
        for (E s : array) {
            if (s.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {

        return null;
    }
}