package hu.flowacademy.lambda._11_patterns.abstract_factory;

public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
