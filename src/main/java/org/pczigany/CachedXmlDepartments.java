package org.pczigany;

import com.jcabi.xml.XML;
import jakarta.annotation.Nonnull;

import java.util.*;

public class CachedXmlDepartments implements Departments {
    private final XML employeeNode;
    private List<String> elements;

    public CachedXmlDepartments(final XML employeeNode) {
        this.employeeNode = employeeNode;
    }

    private void cache() {
        if (elements == null) {
            this.elements = this.employeeNode.xpath("department/text()");
        }
    }

    @Override
    public int size() {
        this.cache();
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        this.cache();
        return this.elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        this.cache();
        return this.elements.contains(o);
    }

    @Override
    public @Nonnull Iterator<String> iterator() {
        this.cache();
        return this.elements.iterator();
    }

    @Override
    public @Nonnull Object[] toArray() {
        this.cache();
        return this.elements.toArray();
    }

    @Override
    public @Nonnull <T> T[] toArray(@Nonnull T[] a) {
        this.cache();
        return this.elements.toArray(a);
    }

    @Override
    public boolean add(String s) {
        this.cache();
        return this.elements.add(s);
    }

    @Override
    public boolean remove(Object o) {
        this.cache();
        return this.elements.remove(o);
    }

    @Override
    public boolean containsAll(@Nonnull Collection<?> c) {
        this.cache();
        return new HashSet<>(this.elements).containsAll(c);
    }

    @Override
    public boolean addAll(@Nonnull Collection<? extends String> c) {
        this.cache();
        return this.elements.addAll(c);
    }

    @Override
    public boolean addAll(int index, @Nonnull Collection<? extends String> c) {
        this.cache();
        return this.elements.addAll(index, c);
    }

    @Override
    public boolean removeAll(@Nonnull Collection<?> c) {
        this.cache();
        return this.elements.removeAll(c);
    }

    @Override
    public boolean retainAll(@Nonnull Collection<?> c) {
        this.cache();
        return this.elements.retainAll(c);
    }

    @Override
    public void clear() {
        this.cache();
        this.elements.clear();
    }

    @Override
    public String get(int index) {
        this.cache();
        return this.elements.get(index);
    }

    @Override
    public String set(int index, String element) {
        this.cache();
        return this.elements.set(index, element);
    }

    @Override
    public void add(int index, String element) {
        this.cache();
        this.elements.add(index, element);
    }

    @Override
    public String remove(int index) {
        this.cache();
        return this.elements.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        this.cache();
        return this.elements.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        this.cache();
        return this.elements.lastIndexOf(o);
    }

    @Override
    public @Nonnull ListIterator<String> listIterator() {
        this.cache();
        return this.elements.listIterator();
    }

    @Override
    public @Nonnull ListIterator<String> listIterator(int index) {
        this.cache();
        return this.elements.listIterator(index);
    }

    @Override
    public @Nonnull List<String> subList(int fromIndex, int toIndex) {
        this.cache();
        return this.elements.subList(fromIndex, toIndex);
    }
}
