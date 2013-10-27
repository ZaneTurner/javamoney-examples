package org.javamoney.examples.fxdemo.widgets;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javax.money.CurrencyUnit;

import org.javamoney.examples.fxdemo.AbstractFXMLComponent;
import org.javamoney.moneta.MoneyCurrency;

/**
 * @author Anatole Tresch
 * @author Werner Keil
 */
public class CurrencySelector extends AbstractFXMLComponent {

	@FXML
	private ComboBox<CurrencyUnit> codeBox;

	@FXML
	private Label currencyTitle;

	public CurrencySelector(String title) {
		super("/org/javamoney/examples/fxdemo/widgets/CurrencySelector.fxml");
		this.currencyTitle.setText(title);
	}

	public MoneyCurrency getCurrency() {
		String code = codeBox.getSelectionModel().getSelectedItem().getCurrencyCode();
		if (code != null) {
			return MoneyCurrency.of(code);
		}
		return null;
	}

	public void setCurrency(CurrencyUnit unit) {
		if (unit != null) {
			codeBox.getSelectionModel().select(unit);
		} else {
			codeBox.getSelectionModel().clearSelection();
		}
	}

}
