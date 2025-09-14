package org.pczigany;

import java.util.Objects;

public class TextName implements Name {
    private final String text;

    public TextName(final String text) {
        this.text = text;
    }

    @Override
    public String text() {
        return this.text;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TextName textName = (TextName) o;
        return Objects.equals(text, textName.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }
}
