package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.day03.Day3CoordinateEntry;
import main.day04.Day4DateTimeString;
import main.day06.Day6Point;
import main.day07.Day7Node;
import main.day10.Day10Point;
import main.day16.TestSample;
import main.day17.Day17Line;

public class AoCFileReader {
    public static List<Integer> readIntegerLineVertical(File f) {
        List<Integer> res = new ArrayList<Integer>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<List<String>> readListOfCharList(File f) {
        List<List<String>> res = new ArrayList<List<String>>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> charLine = new ArrayList<String>();
                for (char c : line.toCharArray()) {
                    charLine.add(String.valueOf(c));
                }
                res.add(charLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<Day3CoordinateEntry> readCoordinateList(File f) {
        List<Day3CoordinateEntry> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.add(new Day3CoordinateEntry(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<Day4DateTimeString> readGuardTimes(File f) {
        List<Day4DateTimeString> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.add(new Day4DateTimeString(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String readOneLine(File f) {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            line = br.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static List<String> readMulitpleLines(File f) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<Day6Point> readPointList(File f) {
        List<Day6Point> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            char c = 'A';
            while ((line = br.readLine()) != null) {
                res.add(new Day6Point(line, c++));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<Day7Node> readNodeSet(File f) {
        List<Day7Node> res = new ArrayList<>();
        char c = 'A';
        for (int i = 0; i < 26; ++i) {
            res.add(new Day7Node(c++));
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                Day7Node node = new Day7Node(line);
                if (res.contains(node)) {
                    int idx = res.indexOf(node);
                    res.get(idx).preConditions.addAll(node.preConditions);
                } else {
                    res.add(new Day7Node(line));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<Day10Point> readPointVelList(File f) {
        List<Day10Point> res = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.add(new Day10Point(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static List<Day17Line> readLineList(File f) {
        List<Day17Line> res = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.add(new Day17Line(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
    
    public static Map<String, Character> readStringMap(File f) {
        Map<String, Character> res = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.put(line.split(" => ")[0], line.split(" => ")[1].charAt(0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static List<TestSample> readTestSamples(File f) {
        List<TestSample> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                TestSample ts = new TestSample();
                ts.setBefore(line);
                line = br.readLine();
                ts.setOperations(line);
                line = br.readLine();
                ts.setAfter(line);
                res.add(ts);
                line = br.readLine();
                if (line == null) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<int[]> readProgram(File f) {
        List<int[]> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                int[] pLine = new int[split.length];
                for (int i = 0; i < split.length; ++i) {
                    pLine[i] = Integer.parseInt(split[i]);
                }
                res.add(pLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<String[]> readProgramLines(File f) {
        List<String[]> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line.split(" "));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    
}
