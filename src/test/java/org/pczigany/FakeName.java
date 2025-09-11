package org.pczigany;

public class FakeName implements Name {
    private int numberOfTextCalls;

    @Override
    public String text() {
        this.numberOfTextCalls++;
        return "Fake Name";
    }

    public int getNumberOfTextCalls() {
        return this.numberOfTextCalls;
    }
}
