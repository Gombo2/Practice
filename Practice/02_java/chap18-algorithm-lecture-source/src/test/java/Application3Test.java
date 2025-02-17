private static int input1, input2;
        private static int[] act1, act2;
        private static int[] exp1, exp2;

public Application3Tests() {
}

@BeforeAll
public static void set() {

    /* 예시1 */
    input1 = 8;
    act1 = new int[]{33, 39, 20, 4, 16, 24, 19, 28};
    exp1 = new int[]{4, 16, 19, 20, 24, 28, 33, 39};

    /* 예시2 */
    input2 = 6;
    act2 = new int[]{14, 38, 5, 26, 17, 19};
    exp2 = new int[]{5, 14, 17, 19, 26, 38};
}

public static Stream<Arguments> provideAscendingSource() {
    return Stream.of(
            arguments(input1, act1, exp1),
            arguments(input2, act2, exp2)
    );
}

@DisplayName("삽입 정렬 테스트")
@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
@ParameterizedTest
@MethodSource("provideAscendingSource")
public void selectionSortTests(int length, int[] actual, int[] expected) {
    Application3.solution(length, actual);
    Assertions.assertArrayEquals(expected, actual);
}