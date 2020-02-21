import main.infrastructure.lhc.IBlock;
import main.infrastructure.lhc.detector.Detector;
import main.infrastructure.lhc.experiment.IExperiment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataAnalyticsEngine {

    private IExperiment experiment;

    public static void main(String[] args) {
        Detector detector = new Detector();
        List<IExperiment> experiments = detector.getExperiments();

        task01(experiments);
        System.out.println();

        task02(experiments);
        System.out.println();

        task03(experiments);
        System.out.println();

        task04(experiments);
        System.out.println();

        task05(experiments);
        System.out.println();
    }

    public DataAnalyticsEngine(IExperiment experiment) {
        this.experiment = experiment;
    }

    // [01] Zählen der eindeutigen Blöcke mit mindestens einem Zeichen # an einer beliebigen Stelle.
    public static void task01(List<IExperiment> experiments) {
        System.out.println("[01] Zählen der eindeutigen Blöcke mit mindestens einem Zeichen # an einer beliebigen Stelle.");

        Predicate<IBlock> blockPredicate = block -> block.getStructure().contains("#");

        int count = experiments.stream().mapToInt(e -> (int) e.getBlocks().stream().distinct().filter(blockPredicate).count()).sum();

        System.out.println(count);
    }

    // [02] Selektion der eindeutigen Blöcke welche mit dem Zeichen z enden.
    public static void task02(List<IExperiment> experiments) {
        System.out.println("[02] Selektion der eindeutigen Blöcke welche mit dem Zeichen z enden.");
        Predicate<IBlock> predicate = block -> block.getStructure().endsWith("z");

        experiments.stream().map(e -> e.getBlocks().stream().filter(predicate).map(b -> b.getStructure()).
                distinct().collect(Collectors.joining(" "))).forEach(System.out::print);
    }

    // [03] Aufsteigende Sortierung der eindeutigen Blöcke, welche mit dem Zeichen a beginnen, die Ziffer 9 an einer beliebigen Stelle enthalten und mit dem Zeichen z enden.
    public static void task03(List<IExperiment> experiments) {
        System.out.println("[03] Aufsteigende Sortierung der eindeutigen Blöcke, welche mit dem Zeichen a beginnen, die Ziffer 9 an einer beliebigen Stelle enthalten und mit dem Zeichen z enden.");
        Predicate<IBlock> predicate = block -> block.getStructure().startsWith("a")
                && block.getStructure().contains("9")
                && block.getStructure().endsWith("z");
        Comparator<String> comparator = String::compareTo;
        experiments.stream().map(e -> e.getBlocks().stream().filter(predicate).map(b -> b.getStructure())
                .distinct().sorted(comparator).collect(Collectors.joining(" ")))
                .forEach(System.out::print);
    }

    // [04] Gruppierung der eindeutigen Blöcke, welche die Zeichenfolge ab an einer beliebigen Stelle enthalten.
    public static void task04(List<IExperiment> experiments) {
        System.out.println("[04] Gruppierung der eindeutigen Blöcke, welche die Zeichenfolge ab an einer beliebigen Stelle enthalten.");

        Predicate<IBlock> predicate = block -> block.getStructure().contains("ab");

        experiments.forEach(e -> e.getBlocks().stream().filter(predicate).map(IBlock::getStructure).distinct()
                .collect(Collectors.groupingBy(s -> s.charAt(0)))
                .forEach((k, v) -> System.out.println(k + ": " + v)));
    }

    // [05] Partionierung der eindeutigen Blöcke in zwei Gruppen [i] Block started mit a,b,c und [ii] alle anderen.
    public static void task05(List<IExperiment> experiments) {
        System.out.println("[05] Partionierung der eindeutigen Blöcke in zwei Gruppen [i] Block started mit a,b,c und [ii] alle anderen.");

        Predicate<String> predicate = string -> string.startsWith("a")
                || string.startsWith("b")
                || string.startsWith("c");

        experiments.forEach(e -> e.getBlocks().stream().map(IBlock::getStructure)
                .distinct().collect(Collectors.partitioningBy(predicate))
                .forEach((k, v) -> System.out.println(k + ": " + v.size() + ", ...")));
    }
}
