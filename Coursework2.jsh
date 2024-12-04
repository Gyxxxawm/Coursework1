int getValue(String card) {
    String number = card.substring(0, card.length() - 1);
    String suit = card.substring(card.length() - 1);
    int numValue = switch (number) {
        case "A" -> 1;
        case "J" -> 11;
        case "Q" -> 12;
        case "K" -> 13;
        default -> Integer.parseInt(number);
    };
    int suitValue = "HCDS".indexOf(suit);
    return suitValue * 100 + numValue;
}

int cardCompare(String card1, String card2) {
    int value1 = getValue(card1);
    int value2 = getValue(card2);
    if (value1 < value2) return -1;
    else if (value1 > value2) return 1;
    else return 0;
}

ArrayList<String> bubbleSort(ArrayList<String> list) {
    for (int i = 0; i < list.size() - 1; i++) {
        for (int j = 0; j < list.size() - i - 1; j++) {
            if (cardCompare(list.get(j), list.get(j + 1)) > 0) {
                Collections.swap(list, j, j + 1);
            }
        }
    }
    return list;
}

ArrayList<String> mergeSort(ArrayList<String> list) {
    if (list.size() <= 1) return list;

    ArrayList<String> left = new ArrayList<>();
    ArrayList<String> right = new ArrayList<>();
    for (int i = 0; i < list.size() / 2; i++) {
        left.add(list.get(i));
    }
    for (int i = list.size() / 2; i < list.size(); i++) {
        right.add(list.get(i));
    }

    left = mergeSort(left);
    right = mergeSort(right);

    ArrayList<String> result = new ArrayList<>();
    int i = 0, j = 0;
    while (i < left.size() && j < right.size()) {
        if (cardCompare(left.get(i), right.get(j)) < 0) {
            result.add(left.get(i++));
        } else {
            result.add(right.get(j++));
        }
    }
    while (i < left.size()) {
        result.add(left.get(i++));
    }
    while (j < right.size()) {
        result.add(right.get(j++));
    }

    return result;
}

long measureBubbleSort(String filename) {
    long startTime = System.currentTimeMillis();
    try {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        ArrayList<String> list = new ArrayList<>(lines);
        bubbleSort(list);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return System.currentTimeMillis() - startTime;
}

long measureMergeSort(String filename) {
    long startTime = System.currentTimeMillis();
    try {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        ArrayList<String> list = new ArrayList<>(lines);
        mergeSort(list);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return System.currentTimeMillis() - startTime;
}

void sortComparison(String[] filenames) {
    try (FileWriter writer = new FileWriter("D:\\命令式编程\\src\\sortComparison1.csv")) {
        writer.write(", " + filenames[0].split("\\.")[0].substring(4) + ", " +
                filenames[1].split("\\.")[0].substring(4) + ", " +
                filenames[2].split("\\.")[0].substring(4) + "\n");
        writer.write("bubbleSort, ");
        for (String file : filenames) {
            long time = measureBubbleSort(file);
            writer.write(time + ", ");
        }
        writer.write("\n");
        writer.write("mergeSort, ");
        for (String file : filenames) {
            long time = measureMergeSort(file);
            writer.write(time + ", ");
        }
        writer.close();
        System.out.println("结果已保存到sortComparison.csv文件中");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

System.out.println("开始测试排序算法运行时间...\n");

String[] testFiles = {
    "D:\\命令式编程\\src\\sort10.txt",
    "D:\\命令式编程\\src\\sort100.txt",
    "D:\\命令式编程\\src\\sort10000.txt"
};

for (String file : testFiles) {
    System.out.println("测试文件: " + file);

    long bubbleTime = measureBubbleSort(file);
    System.out.println("冒泡排序时间: " + bubbleTime + " ms");

    long mergeTime = measureMergeSort(file);
    System.out.println("归并排序时间: " + mergeTime + " ms");

    double speedup = (double)bubbleTime / mergeTime;
    System.out.println("性能比(归并/冒泡): " + String.format("%.2f", speedup) + "x faster");
    System.out.println("--------------------");
}

System.out.println("\n生成性能比较报告...");
sortComparison(testFiles);