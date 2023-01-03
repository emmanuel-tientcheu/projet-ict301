package config;

public interface IClient {
    public Client createClient(Client client);
    public Client updateClient(Client client);
    public Client deleteClient(Client client);
    public Client getClient(int idClient);
}
