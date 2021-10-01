package hu.flowacademy.lambda._11_patterns.abstract_factory;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
