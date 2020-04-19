package com.example.crs.model.generic;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Ports {
    public enum PortType {
        USB_3_2_Gen_2_Type_C("USB 3.2 Gen 2 Type-C "), USB_3_2_Gen_1("USB 3.2 Gen 1 "),
        USB_3_2_Gen_2("USB 3.2 Gen 2"), Mini_DisplayPort("Mini DisplayPort"),
        HDMI_4K_60("HDMI (4K @ 60Hz)"), Mic_in("Mic-in"), Headphone_out("Headphone-out"),
        HDMI_4K_30("HDMI (4K @ 30Hz)"), USB_3_2_Gen_1_Type_C("USB 3.2 Gen 1 Type-C "),
        Headset_AMP("Headset AMP"), Gold_Flash_jacks("Gold Flash jacks"),
        Headset_AMP_Gold_Flash_jacks("Headset AMP + Gold Flash jacks"), Thunderbolt_3("Thunderbolt 3"),
        Headphone_Microphone_Combo_Jack("Headphone/Microphone Combo Jack"), HDMI("HDMI"), USB_3_1_Type_C("USB 3.1 Type C"), USB_3_1_Type_A("USB 3.1 Type A"),
        USB_3_0("USB 3.0"), USB_2_0("USB 2.0"), USB_3_1_Gen_1("USB 3.1 Gen 1"), USB_3_1_Gen_1_Type_A("USB 3.1 Gen 1 Type-A");

        String name;
        PortType(String name) {
            this.name = name;
        }
    }

    private class Port {
        int count;
        PortType portType;

        private Port(int count, PortType portType) {
            this.count = count;
            this.portType = portType;
        }

        @NotNull
        @Override
        public String toString() {
            return count + " x " + portType.name;
        }
    }

    private ArrayList<Port> ports;

    public Ports() {
        ports = new ArrayList<>();
    }

    public void addPort(PortType portType, int count) {
        ports. add(new Port(count, portType));
    }

    @NotNull
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Port port : ports) {
            stringBuilder.append(port).append("\n");
        }
        return stringBuilder.toString();
    }
}
