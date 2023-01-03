package config;

public interface IVisiter {
    public Visiter createVisiter(Visiter visiter);
    public Visiter updateVisiter(Visiter visiter);
    public Visiter deleteVisiter(Visiter visiter);
    public Visiter getVisiter(Visiter idVisiter);
}
