// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}

pub fn add_two_numbers(
    l1: Option<Box<ListNode>>,
    l2: Option<Box<ListNode>>,
) -> Option<Box<ListNode>> {
    return add_recursive(l1, l2, 0);
}

fn add_recursive(
    l1: Option<Box<ListNode>>,
    l2: Option<Box<ListNode>>,
    carry: i32,
) -> Option<Box<ListNode>> {
    match (l1, l2, carry) {
        (None, None, 0) => None,
        (l1, None, carry) | (None, l1, carry) => {
            add_recursive(l1, Some(Box::new(ListNode::new(0))), carry)
        }
        (Some(l1), Some(l2), carry) => {
            let total = l1.val + l2.val + carry;
            Some(Box::new(ListNode {
                val: total % 10,
                next: add_recursive(l1.next, l2.next, total / 10),
            }))
        }
    }
}

#[cfg(test)]
mod test {
    use super::*;
    use std::borrow::Borrow;

    fn create_ll(first: i32, second: i32, third: i32) -> ListNode {
        return ListNode {
            val: first,
            next: Some(Box::new(ListNode {
                val: second,
                next: Some(Box::new(ListNode {
                    val: third,
                    next: None,
                })),
            })),
        };
    }

    #[test]
    fn tc1() {
        let first = create_ll(2, 4, 3);
        let second = create_ll(5, 6, 4);
        let expect = create_ll(7, 0, 8);

        let result = add_two_numbers(Some(Box::new(first)), Some(Box::new(second)));

        assert_eq!(expect, *result.unwrap());
    }
}
