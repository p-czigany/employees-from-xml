package org.pczigany;

import com.jcabi.xml.XML;
import jakarta.annotation.Nonnull;

import java.util.*;

public class DefaultDepartments implements Departments {
    private final List<String> elements;

    public DefaultDepartments(final XML employeeNode) {
        this(new XmlAsStringList(employeeNode));
    }

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
    public boolean contains(final Object o) {
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
    public @Nonnull <T> T[] toArray(@Nonnull final T[] a) {
        return this.elements.toArray(a);
    }

    @Override
    public boolean add(final String s) {
        return this.elements.add(s);
    }

    @Override
    public boolean remove(final Object o) {
        return this.elements.remove(o);
    }

    @Override
    public boolean containsAll(@Nonnull final Collection<?> c) {
        return new HashSet<>(this.elements).containsAll(c);
    }

    @Override
    public boolean addAll(@Nonnull final Collection<? extends String> c) {
        return this.elements.addAll(c);
    }

    @Override
    public boolean addAll(final int index, @Nonnull final Collection<? extends String> c) {
        return this.elements.addAll(index, c);
    }

    @Override
    public boolean removeAll(@Nonnull final Collection<?> c) {
        return this.elements.removeAll(c);
    }

    @Override
    public boolean retainAll(@Nonnull final Collection<?> c) {
        return this.elements.retainAll(c);
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

    @Override
    public String get(final int index) {
        return this.elements.get(index);
    }

    @Override
    public String set(final int index, final String element) {
        return this.elements.set(index, element);
    }

    @Override
    public void add(final int index, final String element) {
        this.elements.add(index, element);
    }

    @Override
    public String remove(final int index) {
        return this.elements.remove(index);
    }

    @Override
    public int indexOf(final Object o) {
        return this.elements.indexOf(o);
    }

    @Override
    public int lastIndexOf(final Object o) {
        return this.elements.lastIndexOf(o);
    }

    @Override
    public @Nonnull ListIterator<String> listIterator() {
        return this.elements.listIterator();
    }

    @Override
    public @Nonnull ListIterator<String> listIterator(final int index) {
        return this.elements.listIterator(index);
    }

    @Override
    public @Nonnull List<String> subList(final int fromIndex, final int toIndex) {
        return this.elements.subList(fromIndex, toIndex);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final DefaultDepartments strings = (DefaultDepartments) o;
        return Objects.equals(this.elements, strings.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(elements);
    }
}
