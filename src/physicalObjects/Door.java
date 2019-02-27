package physicalObjects;

public enum  Door { First,Second;

    private boolean isOpen;

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
