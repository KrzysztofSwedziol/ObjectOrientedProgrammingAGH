package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class SimulationEngine{
    private List<Simulation> simulations;
    private List<Thread> threads;
    private ExecutorService executorService;
    public SimulationEngine(List<Simulation> simulations){
        this.threads = new ArrayList<>();
        this.simulations = simulations;
        this.executorService = Executors.newFixedThreadPool(4);
    }
    public void runSync(){
        for(Simulation simulation : simulations){
            simulation.run();
        }
    }
    public void runAsync(){
        for(Simulation sim : simulations){
            try{
                Thread thread = new Thread(sim);
                threads.add(thread);
                thread.start();
            }catch(NullPointerException e){
                System.out.println("Wątek nie działa");
            }
        }
    }
    public void awaitSimulationsEnd(){
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
    public void runAsyncInThreadPool() throws InterruptedException{
        for(Simulation sim : simulations){
            executorService.submit(sim);
        }
    }
}
