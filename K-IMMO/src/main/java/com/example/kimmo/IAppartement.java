package com.example.kimmo;

public interface IAppartement {
    public Appartement createAppartement(Appartement appartement);
    public Appartement updateAppartement(Appartement appartement);
    public Appartement deleteAppartement(Appartement appartement);
    public Appartement getAppartement(int idAppartement);
}
