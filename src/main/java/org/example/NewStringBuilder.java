package org.example;

import java.util.Stack;

public class NewStringBuilder {

    private StringBuilder sb;
    private Stack<SnapShot> history;

    public NewStringBuilder(String str) {
        sb = new StringBuilder(str);
        history = new Stack<>();
    }

    private static class SnapShot {
        private final String state;

        private SnapShot(String state) {
            this.state = state;
        }

        private String getState() {
            return state;
        }
    }

    private void saveState() {
        history.push(new SnapShot(sb.toString()));
    }

    public void undo() {
        if (!history.isEmpty()) {
            SnapShot last = history.pop();
            sb = new StringBuilder(last.getState());
        } else {
            System.out.println("Более раннее состояние не обнаружено");
        }
    }

    public NewStringBuilder append(String str) {
        saveState();
        sb.append(str);
        return this;
    }

    public NewStringBuilder insert(int index, String str) {
        saveState();
        sb.insert(index, str);
        return this;
    }

    public NewStringBuilder delete(int start, int end) {
        saveState();
        sb.delete(start, end);
        return this;
    }

    public NewStringBuilder replace(int start, int end, String str) {
        saveState();
        sb.replace(start, end, str);
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }

}
