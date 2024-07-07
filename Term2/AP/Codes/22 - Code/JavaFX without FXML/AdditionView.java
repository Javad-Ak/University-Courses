import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.function.UnaryOperator;

public class AdditionView {
    private final AdditionController controller;
    private final AdditionModel model;
    private GridPane view;
    private TextField xField;
    private TextField yField;
    private Label sumLabel;

    public AdditionView(AdditionController controller, AdditionModel model) {

        this.controller = controller;
        this.model = model;

        createAndConfigurePane();

        createAndLayoutControls();

        updateControllerFromListeners();

        observeModelAndUpdateControls();

    }

    public Parent asParent() {
        return view;
    }

    private void observeModelAndUpdateControls() {
        model.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obs, Number oldX, Number newX) {
                updateIfNeeded(newX, xField);
            }
        });

        model.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obs, Number oldY, Number newY) {
                updateIfNeeded(newY, yField);
            }
        });

        sumLabel.textProperty().bind(model.sumProperty().asString());
    }

    private void updateIfNeeded(Number value, TextField field) {
        String s = value.toString();
        if (!field.getText().equals(s)) {
            field.setText(s);
        }
    }

    private void updateControllerFromListeners() {
        xField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> obs, String oldText, String newText) {
                controller.updateX(newText);
            }
        });

        yField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> obs, String oldText, String newText) {
                controller.updateY(newText);
            }
        });
    }

    private void createAndLayoutControls() {
        xField = new TextField();
        configTextFieldForInts(xField);

        yField = new TextField();
        configTextFieldForInts(yField);

        sumLabel = new Label();

        view.addRow(0, new Label("X:"), xField);
        view.addRow(1, new Label("Y:"), yField);
        view.addRow(2, new Label("Sum:"), sumLabel);
    }

    private void createAndConfigurePane() {
        view = new GridPane();

        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHalignment(HPos.RIGHT);
        leftCol.setHgrow(Priority.NEVER);

        ColumnConstraints rightCol = new ColumnConstraints();
        rightCol.setHgrow(Priority.SOMETIMES);

        view.getColumnConstraints().addAll(leftCol, rightCol);

        view.setAlignment(Pos.CENTER);
        view.setHgap(8);
        view.setVgap(16);
        view.setPadding(new Insets(25, 25, 25, 25));
    }

    private void configTextFieldForInts(TextField field) {
        field.setPrefWidth(250);
        field.setTextFormatter(new TextFormatter<Integer>(new UnaryOperator<Change>() {
            @Override
            public Change apply(Change c) {
                if (c.getControlNewText().matches("-?\\d*")) {
                    return c;
                }
                return null;
            }
        }));
    }
}