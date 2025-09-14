package org.pczigany;

import com.jcabi.xml.XML;
import jakarta.annotation.Nonnull;

import java.util.*;

public class DefaultDepartments implements Departments {
    private final List<String> departments;

    public DefaultDepartments(final XML employeeNode) {
        this(new XmlAsDepartmentStringList(employeeNode));
    }

    public DefaultDepartments(final List<String> departments) {
        this.departments = departments;
    }

    @Override
    public int size() {
        return this.departments.size();
    }

    @Override
    public boolean isEmpty() {
        return this.departments.isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return this.departments.contains(o);
    }

    @Override
    public @Nonnull Iterator<String> iterator() {
        return this.departments.iterator();
    }

    @Override
    public @Nonnull Object[] toArray() {
        return this.departments.toArray();
    }

    @Override
    public @Nonnull <T> T[] toArray(@Nonnull final T[] a) {
        return this.departments.toArray(a);
    }

    @Override
    public boolean add(final String s) {
        return this.departments.add(s);
    }

    @Override
    public boolean remove(final Object o) {
        return this.departments.remove(o);
    }

    @Override
    public boolean containsAll(@Nonnull final Collection<?> c) {
        return new HashSet<>(this.departments).containsAll(c);
    }

    @Override
    public boolean addAll(@Nonnull final Collection<? extends String> c) {
        return this.departments.addAll(c);
    }

    @Override
    public boolean addAll(
            final int index,
            @Nonnull final Collection<? extends String> c
    ) {
        return this.departments.addAll(index, c);
    }

    @Override
    public boolean removeAll(@Nonnull final Collection<?> c) {
        return this.departments.removeAll(c);
    }

    @Override
    public boolean retainAll(@Nonnull final Collection<?> c) {
        return this.departments.retainAll(c);
    }

    @Override
    public void clear() {
        this.departments.clear();
    }

    @Override
    public String get(final int index) {
        return this.departments.get(index);
    }

    @Override
    public String set(final int index, final String element) {
        return this.departments.set(index, element);
    }

    @Override
    public void add(final int index, final String element) {
        this.departments.add(index, element);
    }

    @Override
    public String remove(final int index) {
        return this.departments.remove(index);
    }

    @Override
    public int indexOf(final Object o) {
        return this.departments.indexOf(o);
    }

    @Override
    public int lastIndexOf(final Object o) {
        return this.departments.lastIndexOf(o);
    }

    @Override
    public @Nonnull ListIterator<String> listIterator() {
        return this.departments.listIterator();
    }

    @Override
    public @Nonnull ListIterator<String> listIterator(final int index) {
        return this.departments.listIterator(index);
    }

    @Override
    public @Nonnull List<String> subList(
            final int fromIndex,
            final int toIndex
    ) {
        return this.departments.subList(fromIndex, toIndex);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final DefaultDepartments strings = (DefaultDepartments) o;
        return Objects.equals(this.departments, strings.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(departments);
    }
}
