package org.pczigany;

import com.jcabi.xml.XML;
import jakarta.annotation.Nonnull;

import java.util.*;

public class XmlAsDepartmentStringList implements List<String> {
    private static final String XPATH_OF_DEPARTMENT_TAG_TEXT =
            "/department/text()";
    private final XML source;

    public XmlAsDepartmentStringList(final XML source) {
        this.source = source;
    }

    private List<String> stringList() {
        return this.source.xpath(XPATH_OF_DEPARTMENT_TAG_TEXT);
    }

    @Override
    public int size() {
        return this.stringList().size();
    }

    @Override
    public boolean isEmpty() {
        return this.stringList().isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return this.stringList().contains(o);
    }

    @Override
    public @Nonnull Iterator<String> iterator() {
        return this.stringList().iterator();
    }

    @Override
    public @Nonnull Object[] toArray() {
        return this.stringList().toArray();
    }

    @Override
    public @Nonnull <T> T[] toArray(@Nonnull final T[] a) {
        return this.stringList().toArray(a);
    }

    @Override
    public boolean add(final String s) {
        return this.stringList().add(s);
    }

    @Override
    public boolean remove(final Object o) {
        return this.stringList().remove(o);
    }

    @Override
    public boolean containsAll(@Nonnull final Collection<?> c) {
        return new HashSet<>(this.stringList()).containsAll(c);
    }

    @Override
    public boolean addAll(@Nonnull final Collection<? extends String> c) {
        return this.stringList().addAll(c);
    }

    @Override
    public boolean addAll(final int index, @Nonnull final Collection<? extends String> c) {
        return this.stringList().addAll(index, c);
    }

    @Override
    public boolean removeAll(@Nonnull final Collection<?> c) {
        return this.stringList().removeAll(c);
    }

    @Override
    public boolean retainAll(@Nonnull Collection<?> c) {
        return this.stringList().retainAll(c);
    }

    @Override
    public void clear() {
        this.stringList().clear();
    }

    @Override
    public String get(final int index) {
        return this.stringList().get(index);
    }

    @Override
    public String set(final int index, final String element) {
        return this.stringList().set(index, element);
    }

    @Override
    public void add(final int index, final String element) {
        this.stringList().add(index, element);
    }

    @Override
    public String remove(final int index) {
        return this.stringList().remove(index);
    }

    @Override
    public int indexOf(final Object o) {
        return this.stringList().indexOf(o);
    }

    @Override
    public int lastIndexOf(final Object o) {
        return this.stringList().lastIndexOf(o);
    }

    @Override
    public @Nonnull ListIterator<String> listIterator() {
        return this.stringList().listIterator();
    }

    @Override
    public @Nonnull ListIterator<String> listIterator(final int index) {
        return this.stringList().listIterator(index);
    }

    @Override
    public @Nonnull List<String> subList(final int fromIndex, final int toIndex) {
        return this.stringList().subList(fromIndex, toIndex);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final XmlAsDepartmentStringList strings = (XmlAsDepartmentStringList) o;
        return Objects.equals(this.stringList(), strings.stringList());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.stringList());
    }
}
