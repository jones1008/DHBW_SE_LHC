package main.infrastructure.security;

public abstract class CryptoEngine {
    public abstract String encrypt(String data);
    public abstract String decrypt(String data);
}
