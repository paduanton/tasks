package ifsul.jogos;

public class JogoDoRato {
    public static void main(String[] args) {

        byte l, c, rato = 7;;
        byte m[][] = new byte[][] { { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 1, 0, 0, 1, 0, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 1, 0, 0, 0, 1, 1, 0, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 1, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 } };

        m[0][0] = rato;

        do {
            for(l = 0; l <= 9; l++) {
                for(c = 0; c <= 9; c++) {

                    if(m[l][c] == rato) {
                        int y = 0, x = 0;

                        if(c != 9 && m[l][c + 1] == 1) {
                            y++;
                        }
                        if(c != 9 && l != 9 && m[l + 1][c + 1] == 1) {
                            y++;
                        }
                        if(l != 9 && m[l + 1][c] == 1) {
                            y++;
                        }
                        if(c != 0 && l != 9 && m[l + 1][c - 1] == 1) {
                            y++;
                        }
                        if(c != 0 && m[l][c - 1] == 1) {
                            y++;
                        }
                        if(c != 0 && l != 0 && m[l - 1][c - 1] == 1) {
                            y++;
                        }
                        if(l != 0 && m[l - 1][c] == 1) {
                            y++;
                        }
                        if(c != 9 && l != 0 && m[l - 1][c + 1] == 1) {
                            y++;
                        }

                        if(c != 9 && m[l][c + 1] == 1) {
                            m[l][c + 1] = rato;
                        } else {
                            if(c != 9 && l != 9 && m[l + 1][c + 1] == 1) {
                                m[l + 1][c + 1] = rato;
                                x = 2;
                            } else {
                                if(l != 9 && m[l + 1][c] == 1) {
                                    m[l + 1][c] = rato;
                                    x = 2;
                                } else {
                                    if(c != 0 && l != 9
                                            && m[l + 1][c - 1] == 1) {
                                        m[l + 1][c - 1] = rato;
                                        x = 2;
                                    } else {
                                        if(c != 0 && m[l][c - 1] == 1) {
                                            m[l][c - 1] = rato;
                                        } else {
                                            if(c != 0 && l != 0
                                                    && m[l - 1][c - 1] == 1) {
                                                m[l - 1][c - 1] = rato;
                                            } else {
                                                if(l != 0 && m[l - 1][c] == 1) {
                                                    m[l - 1][c] = rato;
                                                } else {
                                                    if(c != 9
                                                            && l != 0
                                                            && m[l - 1][c + 1] == 1) {
                                                        m[l - 1][c + 1] = rato;
                                                    } else {

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if(m[l][c] == rato) {
                            m[l][c] = 8;
                        }

                        if(y == 0 && x == 2) {   // volta de baixo pra cima
                            if(c != 0 && m[l][c - 1] == 3) {
                                m[l][c - 1] = rato;
                            } else {
                                if(c != 0 && l != 0 && m[l - 1][c - 1] == 3) {
                                    m[l - 1][c - 1] = rato;
                                } else {
                                    if(l != 0 && m[l - 1][c] == 3) {
                                        m[l - 1][c] = rato;
                                    } else {
                                        if(c != 9 && l != 0
                                                && m[l - 1][c + 1] == 3) {
                                            m[l - 1][c + 1] = rato;
                                        } else {
                                            if(c != 9 && m[l][c + 1] == 3) {
                                                m[l][c + 1] = rato;
                                            } else {
                                                if(c != 9 && l != 9
                                                        && m[l + 1][c + 1] == 3) {
                                                    m[l + 1][c + 1] = rato;
                                                } else {
                                                    if(l != 9
                                                            && m[l + 1][c] == 3) {
                                                        m[l + 1][c] = rato;
                                                    } else {
                                                        if(c != 0
                                                                && l != 9
                                                                && m[l + 1][c - 1] == 3) {
                                                            m[l + 1][c - 1] = rato;
                                                        } else {

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }

                        if(y == 0) {  // volta de cima pra baixo
                            if(c != 9 && m[l][c + 1] == 3) {
                                m[l][c + 1] = rato;

                            } else {
                                if(c != 9 && l != 9 && m[l + 1][c + 1] == 3) {
                                    m[l + 1][c + 1] = rato;
                                } else {
                                    if(l != 9 && m[l + 1][c] == 3) {
                                        m[l + 1][c] = rato;
                                    } else {
                                        if(c != 0 && l != 9
                                                && m[l + 1][c - 1] == 3) {
                                            m[l + 1][c - 1] = rato;
                                        } else {
                                            if(c != 0 && m[l][c - 1] == 3) {
                                                m[l][c - 1] = rato;
                                            } else {
                                                if(c != 0 && l != 0
                                                        && m[l - 1][c - 1] == 3) {
                                                    m[l - 1][c - 1] = rato;
                                                } else {
                                                    if(l != 0
                                                            && m[l - 1][c] == 3) {
                                                        m[l - 1][c] = rato;
                                                    } else {
                                                        if(c != 9
                                                                && l != 0
                                                                && m[l - 1][c + 1] == 3) {
                                                            m[l - 1][c + 1] = rato;
                                                        } else {

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }

                    }

                }
            }

        } while (m[9][9] == 1);

        for(int linha = 0; linha <= 9; linha++) {
            for(int coluna = 0; coluna <= 9; coluna++) {
                if(m[linha][coluna] == rato) {
                    m[linha][coluna] = 3;
                }
            }
        }

        System.out.println(" ");
        for(l = 0; l < 10; l++) {
            System.out.println(m[l][0] + " " + m[l][1] + " " + m[l][2] + " "
                    + m[l][3] + " " + m[l][4] + " " + m[l][5] + " " + m[l][6]
                    + " " + m[l][7] + " " + m[l][8] + " " + m[l][9]);
        }
    }
}