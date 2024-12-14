import java.util.Scanner;

class FirstFitMemoryAllocation {
    // Method to allocate memory to blocks as per the First Fit algorithm
    static void firstFit(int blockSize[], int m, int processSize[], int n) {
        // Stores block id of the block allocated to a process
        int allocation[] = new int[n];

        // Initially, no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // Pick each process and find suitable blocks
        // according to its size and assign to it
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    // Allocate block j to process i
                    allocation[i] = j;

                    // Reduce available memory in this block
                    blockSize[j] -= processSize[i];

                    break;
                }
            }
        }

        // Print process allocation results
        System.out.println("\n-------------------------------------------");
        System.out.printf("| %-10s | %-12s | %-10s |\n", "Process No.", "Process Size", "Block No.");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("| %-10d | %-12d | %-10s |\n", (i + 1), processSize[i],
                    (allocation[i] != -1 ? allocation[i] + 1 : "Not Allocated"));
        }
        System.out.println("-------------------------------------------");

        // Print remaining memory in each block
        System.out.println("\n----------------------------------");
        System.out.printf("| %-10s | %-17s |\n", "Block No.", "Remaining Memory");
        System.out.println("----------------------------------");
        for (int i = 0; i < m; i++) {
            System.out.printf("| %-10d | %-17d |\n", (i + 1), blockSize[i]);
        }
        System.out.println("----------------------------------");
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get number of blocks
        System.out.print("Enter the number of memory blocks: ");
        int m = sc.nextInt();
        int blockSize[] = new int[m];

        // Input block sizes
        System.out.println("Enter the sizes of the memory blocks:");
        for (int i = 0; i < m; i++) {
            System.out.print("Block " + (i + 1) + ": ");
            blockSize[i] = sc.nextInt();
        }

        // Get number of processes
        System.out.print("\nEnter the number of processes: ");
        int n = sc.nextInt();
        int processSize[] = new int[n];

        // Input process sizes
        System.out.println("Enter the sizes of the processes:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            processSize[i] = sc.nextInt();
        }

        // Call firstFit method
        firstFit(blockSize, m, processSize, n);

        sc.close();
    }
}