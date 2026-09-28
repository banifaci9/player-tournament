package ru.netology.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.register(new Player(1, "Anna", 100));
        game.register(new Player(2, "Boris", 50));
        game.register(new Player(3, "Clara", 100));
    }

    @Test
    void shouldReturnOneWhenFirstPlayerIsStronger() {
        assertEquals(1, game.round("Anna", "Boris"));
    }

    @Test
    void shouldReturnTwoWhenSecondPlayerIsStronger() {
        assertEquals(2, game.round("Boris", "Anna"));
    }

    @Test
    void shouldReturnZeroWhenStrengthsAreEqual() {
        assertEquals(0, game.round("Anna", "Clara"));
    }

    @Test
    void shouldThrowWhenFirstPlayerIsNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Unknown", "Anna"));
    }

    @Test
    void shouldThrowWhenSecondPlayerIsNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Anna", "Unknown"));
    }

    @Test
    void shouldThrowWhenBothPlayersAreNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Unknown", "Missing"));
    }

    @Test
    void shouldThrowWhenNoPlayersAreRegistered() {
        Game emptyGame = new Game();
        assertThrows(NotRegisteredException.class, () -> emptyGame.round("Anna", "Boris"));
    }

    @Test
    void shouldAllowNewlyRegisteredPlayerToParticipate() {
        game.register(new Player(4, "Diana", 200));
        assertEquals(1, game.round("Diana", "Anna"));
    }
}
