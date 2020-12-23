use std::collections::HashMap;
use std::cmp;

pub fn length_of_longest_substring(s: String) -> i32 {
    let s: Vec<char> = s.chars().collect();

    let mut max_len = 0;
    let mut left = 0;
    let mut right = 0;

    let mut map: HashMap<&char, i32> = HashMap::new();

    while left < s.len() && right < s.len() {
        let next = s.get(right).unwrap();
        let prev = s.get(left).unwrap();
        let next_count = map.get(next).unwrap_or(&0);
        let prev_count = map.get(prev).unwrap_or(&0);
        if next_count >= &1 {
            map.insert(prev, prev_count - 1);
            left += 1;
        } else {
            max_len = cmp::max(max_len, right - left + 1);
            map.insert(next, next_count + 1);
            right += 1;
        }
    }

    return max_len as i32
}


#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn tc1() {
        assert_eq!(
            3,
            length_of_longest_substring(String::from("abacb"))
        )
    }

    #[test]
    fn tc2() {
        assert_eq!(
            2,
            length_of_longest_substring(String::from("abab"))
        )
    }

    #[test]
    fn tc3() {
        assert_eq!(
            4,
            length_of_longest_substring(String::from("abcd"))
        )
    }

    #[test]
    fn tc4() {
        assert_eq!(
            1,
            length_of_longest_substring(String::from("aaaa"))
        )
    }

    #[test]
    fn tc5() {
        assert_eq!(
            0,
            length_of_longest_substring(String::from(""))
        )
    }
}
