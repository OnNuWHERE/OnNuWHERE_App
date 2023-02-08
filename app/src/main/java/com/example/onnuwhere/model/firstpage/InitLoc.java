package com.example.onnuwhere.model.firstpage;

public class InitLoc {

    private InitAddr address;

    private InitRoadAddr road_address;

    public InitRoadAddr getRoad_address() {
        return road_address;
    }

    public void setRoad_address(InitRoadAddr road_address) {
        this.road_address = road_address;
    }

    public InitAddr getAddress() {
        return address;
    }

    public void setAddress(InitAddr address) {
        this.address = address;
    }
}
