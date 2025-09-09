package org.pczigany;

import com.jcabi.xml.XMLDocument;
import jakarta.annotation.Nonnull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PathAsEmployeeList implements List<Employee> {
    private final String source;
    public PathAsEmployeeList(final String path) {
        this.source = path;
    }

    private List<Employee> employeeList() {
        final InputStream xmlStream =
                getClass().getClassLoader().getResourceAsStream(this.source);
        try {
            if (xmlStream == null) {
                throw new FileNotFoundException(
                        "employee.xml not found in resources folder"
                );
            }
            return new ArrayList<>(
                    new XMLDocument(xmlStream).nodes("//employee").stream()
                            .map(XmlEmployee::new).toList()
            );
        } catch (final IOException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public int size() {
        return this.employeeList().size();
    }

    @Override
    public boolean isEmpty() {
        return this.employeeList().isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return this.employeeList().contains(o);
    }

    @Override
    public @Nonnull Iterator<Employee> iterator() {
        return this.employeeList().iterator();
    }

    @Override
    public @Nonnull Object[] toArray() {
        return this.employeeList().toArray();
    }

    @Override
    public @Nonnull <T> T[] toArray(@Nonnull final T[] a) {
        return this.employeeList().toArray(a);
    }

    @Override
    public boolean add(final Employee s) {
        return this.employeeList().add(s);
    }

    @Override
    public boolean remove(final Object o) {
        return this.employeeList().remove(o);
    }

    @Override
    public boolean containsAll(@Nonnull final Collection<?> c) {
        return new HashSet<>(this.employeeList()).containsAll(c);
    }

    @Override
    public boolean addAll(@Nonnull final Collection<? extends Employee> c) {
        return this.employeeList().addAll(c);
    }

    @Override
    public boolean addAll(final int index, @Nonnull final Collection<? extends Employee> c) {
        return this.employeeList().addAll(index, c);
    }

    @Override
    public boolean removeAll(@Nonnull final Collection<?> c) {
        return this.employeeList().removeAll(c);
    }

    @Override
    public boolean retainAll(@Nonnull Collection<?> c) {
        return this.employeeList().retainAll(c);
    }

    @Override
    public void clear() {
        this.employeeList().clear();
    }

    @Override
    public Employee get(final int index) {
        return this.employeeList().get(index);
    }

    @Override
    public Employee set(final int index, final Employee element) {
        return this.employeeList().set(index, element);
    }

    @Override
    public void add(final int index, final Employee element) {
        this.employeeList().add(index, element);
    }

    @Override
    public Employee remove(final int index) {
        return this.employeeList().remove(index);
    }

    @Override
    public int indexOf(final Object o) {
        return this.employeeList().indexOf(o);
    }

    @Override
    public int lastIndexOf(final Object o) {
        return this.employeeList().lastIndexOf(o);
    }

    @Override
    public @Nonnull ListIterator<Employee> listIterator() {
        return this.employeeList().listIterator();
    }

    @Override
    public @Nonnull ListIterator<Employee> listIterator(final int index) {
        return this.employeeList().listIterator(index);
    }

    @Override
    public @Nonnull List<Employee> subList(final int fromIndex, final int toIndex) {
        return this.employeeList().subList(fromIndex, toIndex);
    }
}
