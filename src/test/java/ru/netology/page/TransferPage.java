package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement sumField = $("[type='text']");
    private SelenideElement fromField = $("[type='tel']");
    private SelenideElement cardField = $("[data-test-id='to']");
    private SelenideElement sendButton = $("[data-test-id='action-transfer']");
    private SelenideElement cancelButton = $("[data-test-id='action-cancel']");

    public void transfer(DataHelper.Card card, int amount) {
        sumField.setValue(String.valueOf(amount));
        fromField.setValue(card.getNumber());
        sendButton.click();
    }

    public SelenideElement errorMessage() {
        return $(withText("У вас недостаточно средств на карте")).shouldBe(Condition.visible);
    }
}
