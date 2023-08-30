package classes;


public class Relogio {
    private int hora;   
    private int minuto; 
    private int segundo; 
    
    public Relogio(int hora, int minuto, int segundo) {
        if (hora >= 0 && hora < 24 && minuto >= 0 && minuto < 60 && segundo >= 0 && segundo < 60) {
            this.hora = hora;
            this.minuto = minuto;
            this.segundo = segundo;
        } else {
            throw new IllegalArgumentException("Valores inválidos para hora, minuto ou segundo.");
        }
    }
    
    public void setHora(int hora) {
        if (hora >= 0 && hora < 24) {
            this.hora = hora;
        } else {
            throw new IllegalArgumentException("Hora inválida.");
        }
    }
    
    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto < 60) {
            this.minuto = minuto;
        } else {
            throw new IllegalArgumentException("Minuto inválido.");
        }
    }
    
    public void setSegundo(int segundo) {
        if (segundo >= 0 && segundo < 60) {
            this.segundo = segundo;
        } else {
            throw new IllegalArgumentException("Segundo inválido.");
        }
    }
    
    
    public String toString() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }
    
    private long inicioCronometro;
    private boolean cronometroLigado;

    public void ligarCronometro() {
        if (!cronometroLigado) {
            inicioCronometro = System.currentTimeMillis();
            cronometroLigado = true;
        }
    }

    public void desligarCronometro() {
        if (cronometroLigado) {
            cronometroLigado = false;
        }
    }

    public void zerarCronometro() {
        inicioCronometro = 0;
        cronometroLigado = false;
    }

    public long tempoDecorridoCronometro() {
        if (cronometroLigado) {
            return System.currentTimeMillis() - inicioCronometro;
        } else {
            return 0;
        }
    }
    
    public String citarHora() {
        return String.format("Agora são %02d:%02d:%02d.", hora, minuto, segundo);
    }

    
    private int alarmeHora;
    private int alarmeMinuto;

    public void definirAlarme(int hora, int minuto) {
        if (hora >= 0 && hora < 24 && minuto >= 0 && minuto < 60) {
            alarmeHora = hora;
            alarmeMinuto = minuto;
        } else {
            throw new IllegalArgumentException("Valores inválidos para hora ou minuto do alarme.");
        }
    }

    public boolean verificarAlarme() {
        return hora == alarmeHora && minuto == alarmeMinuto && segundo == 0;
    }
    
    public void aumentarHora() {
        hora++;
        if (hora >= 24) {
            hora = 0;
        }
    }
    
    public void aumentarMinuto() {
        minuto++;
        if (minuto >= 60) {
            minuto = 0;
            aumentarHora();
        }
    }
    
    public void aumentarSegundo() {
        segundo++;
        if (segundo >= 60) {
            segundo = 0;
            aumentarMinuto();
        }
    }
    
}
    
    
