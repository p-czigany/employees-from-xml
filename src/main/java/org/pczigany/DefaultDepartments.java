package org.pczigany;

import jakarta.annotation.Nonnull;

import java.util.*;

public class DefaultDepartments implements Departments {
    private final List<String> elements;

    public DefaultDepartments(final List<String> elements) {
        this.elements = elements;
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.elements.contains(o);
    }

    @Override
    public @Nonnull Iterator<String> iterator() {
        return this.elements.iterator();
    }

    @Override
    public @Nonnull Object[] toArray() {
        return this.elements.toArray();
    }

    @Override
    public @Nonnull <T> T[] toArray(@Nonnull T[] a) {
        return this.elements.toArray(a);
    }

    @Override
    public boolean add(String s) {
        return this.elements.add(s);
    }

    @Override
    public boolean remove(Object o) {
        return this.elements.remove(o);
    }

    @Override
    public boolean containsAll(@Nonnull Collection<?> c) {
        return new HashSet<>(this.elements).containsAll(c);
    }

    @Override
    public boolean addAll(@Nonnull Collection<? extends String> c) {
        return this.elements.addAll(c);
    }

    @Override
    public boolean addAll(int index, @Nonnull Collection<? extends String> c) {
        return this.elements.addAll(index, c);
    }

    @Override
    public boolean removeAll(@Nonnull Collection<?> c) {
        return this.elements.removeAll(c);
    }

    @Override
    public boolean retainAll(@Nonnull Collection<?> c) {
        return this.elements.retainAll(c);
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

    @Override
    public String get(int index) {
        return this.elements.get(index);
    }

    @Override
    public String set(int index, String element) {
        return this.elements.set(index, element);
    }

    @Override
    public void add(int index, String element) {
        this.elements.add(index, element);
    }

    @Override
    public String remove(int index) {
        return this.elements.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.elements.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.elements.lastIndexOf(o);
    }

    @Override
    public @Nonnull ListIterator<String> listIterator() {
        return this.elements.listIterator();
    }

    @Override
    public @Nonnull ListIterator<String> listIterator(int index) {
        return this.elements.listIterator(index);
    }

    @Override
    public @Nonnull List<String> subList(int fromIndex, int toIndex) {
        return this.elements.subList(fromIndex, toIndex);
    }
}
