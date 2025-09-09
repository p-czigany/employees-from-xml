package org.pczigany;

public class DefaultName implements Name {
    private final String text;

    public DefaultName(final String text) {
        this.text = text;
    }

    @Override
    public String text() {
        return this.text;
    }
}
