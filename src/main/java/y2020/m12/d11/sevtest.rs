fn add_two(a: i32) -> i32 {
    return a + 2;
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn internal() {
        assert_eq!(4, add_two(2));
    }
}
