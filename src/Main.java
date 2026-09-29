import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import List.SinglyLinkedList;
import List.SinglyLinkedListTail;
import List.DoublyLinkedList;
import List.DoublyLinkedListTail;
import List.Node;
import List.DoubleNode;
import Stack.DynamicArrayStack;
import Queue.DynamicArrayQueue;

interface Operation {
    void apply(int i);
}

public class Main {

    // Método exec adaptado a la plantilla original, midiendo en microsegundos (µs)
    public static double exec(int size, String method, Operation operation) {
        Instant start = Instant.now();        
        
        for (int i = 0; i < size; i++) {
            operation.apply(i);
        }

        Instant finish = Instant.now();
        double timeElapsedMicros = Duration.between(start, finish).toNanos() / 1000.0;
        
        System.out.printf("%-40s | N: %-7d | Tiempo: %10.3f µs\n", method, size, timeElapsedMicros);
        return timeElapsedMicros;
    }

    public static void main(String[] args) {
        // Tamaños de entrada según el taller
        final int[] sizes = {10, 100, 1000, 10000, 100000};
        Random random = new Random();

        System.out.println("=========================================================================================");
        System.out.println("                MEDICIÓN DE TIEMPOS DE EJECUCIÓN EN CONSOLA                               ");
        System.out.println("=========================================================================================\n");

        for (int size : sizes) {
            System.out.printf("\n==================== EVALUANDO TAMAÑO DE ENTRADA N = %d ====================\n\n", size);

            for (int iter = 1; iter <= 5; iter++) {
                System.out.println("--- Iteración " + iter + " ---");

                // =============================================================
                // 1. SINGLY LINKED LIST (Sin Tail)
                // =============================================================
                SinglyLinkedList sList = new SinglyLinkedList<>();
                exec(size, "SinglyLinkedList - pushFront", sList::pushFront);
                exec(size, "SinglyLinkedList - topFront", i -> sList.topFront());
                exec(size, "SinglyLinkedList - topBack", i -> sList.topBack());
                exec(size, "SinglyLinkedList - getSize", i -> sList.getSize());
                exec(size, "SinglyLinkedList - isEmpty", i -> sList.isEmpty());

                SinglyLinkedList sListBack = new SinglyLinkedList<>();
                exec(size, "SinglyLinkedList - pushBack", sListBack::pushBack);

                // Garantizamos la existencia de un nodo intermedio para addBefore y addAfter
                Node targetS = sListBack.find(size / 2);
                if (targetS != null) {
                    exec(size, "SinglyLinkedList - addAfter", i -> sListBack.addAfter(targetS, i));
                    exec(size, "SinglyLinkedList - addBefore", i -> sListBack.addBefore(targetS, i));
                }

                exec(size, "SinglyLinkedList - find", i -> sListBack.find(random.nextInt(size)));
                exec(size, "SinglyLinkedList - erase", i -> sListBack.erase(random.nextInt(size)));
                exec(size, "SinglyLinkedList - popFront", i -> { if (!sList.isEmpty()) sList.popFront(); });
                exec(size, "SinglyLinkedList - popBack", i -> { if (!sListBack.isEmpty()) sListBack.popBack(); });


                // =============================================================
                // 2. SINGLY LINKED LIST WITH TAIL (Con Cola)
                // =============================================================
                SinglyLinkedListTail sListTail = new SinglyLinkedListTail<>();
                exec(size, "SinglyLinkedListTail - pushFront", sListTail::pushFront);
                exec(size, "SinglyLinkedListTail - topFront", i -> sListTail.topFront());
                exec(size, "SinglyLinkedListTail - topBack", i -> sListTail.topBack());
                exec(size, "SinglyLinkedListTail - getSize", i -> sListTail.getSize());
                exec(size, "SinglyLinkedListTail - isEmpty", i -> sListTail.isEmpty());

                SinglyLinkedListTail sListTailBack = new SinglyLinkedListTail<>();
                exec(size, "SinglyLinkedListTail - pushBack", sListTailBack::pushBack);

                Node targetST = sListTailBack.find(size / 2);
                if (targetST != null) {
                    exec(size, "SinglyLinkedListTail - addAfter", i -> sListTailBack.addAfter(targetST, i));
                    exec(size, "SinglyLinkedListTail - addBefore", i -> sListTailBack.addBefore(targetST, i));
                }

                exec(size, "SinglyLinkedListTail - find", i -> sListTailBack.find(random.nextInt(size)));
                exec(size, "SinglyLinkedListTail - erase", i -> sListTailBack.erase(random.nextInt(size)));
                exec(size, "SinglyLinkedListTail - popFront", i -> { if (!sListTail.isEmpty()) sListTail.popFront(); });
                exec(size, "SinglyLinkedListTail - popBack", i -> { if (!sListTailBack.isEmpty()) sListTailBack.popBack(); });


                // =============================================================
                // 3. DOUBLY LINKED LIST (Sin Tail)
                // =============================================================
                DoublyLinkedList dList = new DoublyLinkedList<>();
                exec(size, "DoublyLinkedList - pushFront", dList::pushFront);
                exec(size, "DoublyLinkedList - topFront", i -> dList.topFront());
                exec(size, "DoublyLinkedList - topBack", i -> dList.topBack());
                exec(size, "DoublyLinkedList - getSize", i -> dList.getSize());
                exec(size, "DoublyLinkedList - isEmpty", i -> dList.isEmpty());

                DoublyLinkedList dListBack = new DoublyLinkedList<>();
                exec(size, "DoublyLinkedList - pushBack", dListBack::pushBack);

                DoubleNode targetD = dListBack.find(size / 2);
                if (targetD != null) {
                    exec(size, "DoublyLinkedList - addAfter", i -> dListBack.addAfter(targetD, i));
                    exec(size, "DoublyLinkedList - addBefore", i -> dListBack.addBefore(targetD, i));
                }

                exec(size, "DoublyLinkedList - find", i -> dListBack.find(random.nextInt(size)));
                exec(size, "DoublyLinkedList - erase", i -> dListBack.erase(random.nextInt(size)));
                exec(size, "DoublyLinkedList - popFront", i -> { if (!dList.isEmpty()) dList.popFront(); });
                exec(size, "DoublyLinkedList - popBack", i -> { if (!dListBack.isEmpty()) dListBack.popBack(); });


                // =============================================================
                // 4. DOUBLY LINKED LIST WITH TAIL (Con Cola)
                // =============================================================
                DoublyLinkedListTail dListTail = new DoublyLinkedListTail<>();
                exec(size, "DoublyLinkedListTail - pushFront", dListTail::pushFront);
                exec(size, "DoublyLinkedListTail - topFront", i -> dListTail.topFront());
                exec(size, "DoublyLinkedListTail - topBack", i -> dListTail.topBack());
                exec(size, "DoublyLinkedListTail - getSize", i -> dListTail.getSize());
                exec(size, "DoublyLinkedListTail - isEmpty", i -> dListTail.isEmpty());

                DoublyLinkedListTail dListTailBack = new DoublyLinkedListTail<>();
                exec(size, "DoublyLinkedListTail - pushBack", dListTailBack::pushBack);

                DoubleNode targetDT = dListTailBack.find(size / 2);
                if (targetDT != null) {
                    exec(size, "DoublyLinkedListTail - addAfter", i -> dListTailBack.addAfter(targetDT, i));
                    exec(size, "DoublyLinkedListTail - addBefore", i -> dListTailBack.addBefore(targetDT, i));
                }

                exec(size, "DoublyLinkedListTail - find", i -> dListTailBack.find(random.nextInt(size)));
                exec(size, "DoublyLinkedListTail - erase", i -> dListTailBack.erase(random.nextInt(size)));
                exec(size, "DoublyLinkedListTail - popFront", i -> { if (!dListTail.isEmpty()) dListTail.popFront(); });
                exec(size, "DoublyLinkedListTail - popBack", i -> { if (!dListTailBack.isEmpty()) dListTailBack.popBack(); });


                // =============================================================
                // 5. MYSTACK (DynamicArrayStack)
                // =============================================================
                DynamicArrayStack stack = new DynamicArrayStack<>();
                exec(size, "DynamicArrayStack - push", stack::push);
                exec(size, "DynamicArrayStack - peek", i -> { if (!stack.isEmpty()) stack.peek(); });
                exec(size, "DynamicArrayStack - size", i -> stack.getSize());
                exec(size, "DynamicArrayStack - isEmpty", i -> stack.isEmpty());
                exec(size, "DynamicArrayStack - delete", i -> stack.delete(random.nextInt(size)));
                exec(size, "DynamicArrayStack - pop", i -> { if (!stack.isEmpty()) stack.pop(); });


                // =============================================================
                // 6. MYQUEUE (DynamicArrayQueue)
                // =============================================================
                DynamicArrayQueue queue = new DynamicArrayQueue<>();
                exec(size, "DynamicArrayQueue - enqueue", queue::enqueue);
                exec(size, "DynamicArrayQueue - front", i -> { if (!queue.isEmpty()) queue.front(); });
                exec(size, "DynamicArrayQueue - size", i -> queue.getSize());
                exec(size, "DynamicArrayQueue - isEmpty", i -> queue.isEmpty());
                exec(size, "DynamicArrayQueue - delete", i -> queue.delete(random.nextInt(size)));
                exec(size, "DynamicArrayQueue - dequeue", i -> { if (!queue.isEmpty()) queue.dequeue(); });

                System.out.println("-----------------------------------------------------------------------------------------");
            }
        }
    }
}